package JPL.ch17.ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();

	}

	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
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


}