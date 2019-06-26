import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JRobot extends Robot {
	final Direction[] moveSequence = { Direction.FORWARD, Direction.BACKWARD, Direction.RIGHT, Direction.LEFT };
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
		Stack<Direction> pastMovements = new Stack<>();
		pastMovements.push(Direction.FORWARD);
		clean(pastMovements);
	}
	
	/*
	 * If stack is not empty, checks for possible movements and moves in first direction possible.
	 * when no movement is possible, returns to previous position until robot can move again or arrives at starting position
	 * 
	 * @param pastMovements stack holding previous movements of robot
	 */
	public int clean(Stack<Direction> pastMovements) {
		if (pastMovements.isEmpty()) {// Base case
			return -1;
		}
		for (Direction d : moveSequence) {
			if (this.canMove(d) && !this.haveBeen(d)) {
				this.move(d);
				pastMovements.push(d);
				clean(pastMovements);
			}
		}
		if (!pastMovements.isEmpty()) { // if no path found, backtrack
			Direction lastMove = pastMovements.pop();
			this.move(backTrack.get(lastMove)); // Retrace last step of movement
		}
		return clean(pastMovements);
	}

}