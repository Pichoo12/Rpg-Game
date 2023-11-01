public enum Screen {
	START(0),
	WIZARD(1),
	ARCHER(2),
	DRAG(3),
	BABYDRAG(4),
	GAMESCREEN(5);
	
	public final int index;
    public Object get;
	
	private Screen(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public Screen getScreen(int index) {
		for (Screen s: Screen.values()) {
			if (s.getIndex() == index) {
				return s;
			}
		}
		return null;
	}
}