import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JRobot extends Robot {
	final Map<Direction, Direction> backTrack = new HashMap<Direction, Direction>() {
		{
			put(Direction.FORWARD, Direction.BACKWARD);
			put(Direction.BACKWARD, Direction.FORWARD);
			put(Direction.RIGHT, Direction.LEFT);
			put(Direction.LEFT, Direction.RIGHT);
		}
	};
	/**
	 * Create a new JRobot
	 *
	 * @param show True to include a visual simulation of this JRobot
	 */
	public JRobot(boolean show) {
		super(show);
	}

	/**
	 * Create a new JRobot
	 * 
	 * @param show  True to include a visual simulation of this JRobot
	 * @param delay The delay in miliseconds the JRobot will take between each
	 *              cleaning movement
	 */
	public JRobot(boolean show, int delay) {
		super(show, delay);
	}

	/**
	 * Start cleaning/moving
	 */
	public void start() {
		clean(Direction.FORWARD);
	}
	
	/*
	 * Moves in given direction, checks for possible movements and moves in first direction possible.
	 * when no movement is possible, returns to previous position until robot can move again or arrives at starting position
	 * 
	 * @param d direction in which the robot will move
	 */
	public void clean(Direction d) {
		this.move(d);
		for(Direction dir : Direction.values()) {
			if(this.canMove(dir) && !this.haveBeen(dir)) {
				clean(dir);
			}
		}
		this.move(backTrack.get(d));
	}

}