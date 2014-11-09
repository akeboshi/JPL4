package JPL.ch17.ex17_04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new RepaperThread();
		reaper.start();
	}

	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			reaper.interrupt();
		}
	}

	public synchronized Resource getResource(Object key) {
		if (shutdown) {
			throw new IllegalStateException();
		}

		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}

	private static class ResourceImpl implements Resource {
		Object okey;
		boolean needsRelease = false;

		ResourceImpl(Object key) {
			this.okey = key;

			// 外部リソースの設定

			needsRelease = true;
		}

		@Override
		public void use(Object key, Object... args) {
			if ( !okey.equals(key))
				throw new IllegalArgumentException("wrong key");

			// リソースの使用
		}

		@Override
		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;
			}

			// リソースの解放
		}

	}

	class RepaperThread extends Thread {
		boolean flag = false;
		public void run() {
			while (true) {
				try {
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized (ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
					if(flag && queue.poll() == null){
						break;
					}
				} catch (InterruptedException e) {
					flag = true;
				}
			}
		}
	}
}