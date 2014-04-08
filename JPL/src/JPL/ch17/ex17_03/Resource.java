package JPL.ch17.ex17_03;

interface Resource{
	void use(Object key,Object... args);
	void release();
}