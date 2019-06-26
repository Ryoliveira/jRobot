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


	public int clean(Stack<Direction> pastMovements) {
		boolean foundPath = false;
		if (pastMovements.isEmpty()) {//Base case
			return -1;
		}
		for(Direction d : moveSequence) {
			if (this.canMove(d) && !this.haveBeen(d)) {
				this.move(d);
				pastMovements.push(d);
				foundPath = true;
				break;
			}
		} 
		if(!foundPath){ // if no path found, backtrack
			Direction lastMove = pastMovements.pop();
			this.move(backTrack.get(lastMove)); //Retrace step of movement
		}
		return clean(pastMovements);
	}

}