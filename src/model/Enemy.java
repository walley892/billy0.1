package model;



public class Enemy extends GameObject{
	private int _round;
	
	private DIRECTION _direction;
	private int[] _startingPosition;
	
	public Enemy(Board b, int y, int x, int r){
		super(b);
		_round = r;
		setPosition(y, x);
		_direction = DIRECTION.RIGHT;
		_startingPosition = new int[2];
		_startingPosition[0] = _position[0];
		_startingPosition[1] = _position[1];
		++_position[1];
	}
	public OBJECT_TYPE getType() {
		return OBJECT_TYPE.ENEMY;
	}
	@Override
	public void move(){
		if(Math.random() < .005){
			_board.fire(new Laser(DIRECTION.DOWN, this, _board));
		}
		if((_position[1] > 20 + _startingPosition[1] || _position[1] < _startingPosition[1]) && _direction != DIRECTION.DOWN){
			_direction = DIRECTION.DOWN;
		}
		else
		if(_direction == DIRECTION.DOWN){
			if(_position[1] < _startingPosition[1]){
				_direction = DIRECTION.RIGHT;
			}else{
				_direction = DIRECTION.LEFT;
			}
		}
		switch(_direction){
		case RIGHT:
			_position[1] += _round;
			break;
		case DOWN:
			_position[0] += _round;
			break;
		case LEFT:
			_position[1] -= _round;
			break;
		case UP:
			_position[0] -= _round;
			break;
		default:
			break;
		}
	}

}
