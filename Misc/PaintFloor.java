///*
//	Functions( methods) of a Robot:
//		void move( int direction )	The robot makes one step in a specified direction
//									( 0 – forward; 2 – backward )
//
//		void paint( int color )		The robot paints its current cell in the specified color
//									( 0 – no color (empty); 1 – red; 2 – blue; 3 – green)
//
//		void turn( int direction )	The robot turns in the specified direction
//									( 1 – to the right; 2 - around, 3 – to the left )
//
//		int check( int direction ) 	The robot checks the content of the adjacent cell
//									in a the specified direction
//									( 0 – front, 1 – right, 2 – back, 3 – left )
//									and returns one of the following values
//									( –1 –  obstacle; 0 - empty, 1 - painted red,
//									   2 - painted blue, painted green) ;
//
//
//	Pre Conditions:
//   		A room (without doors) has irregular form.
//   		The floor of the room is covered with square tiles.
//   		Some obstacles, also of irregular form, are located on the floor.
//   		Each obstable occuries a certain number of tiles.
//   		A robot is located at an empty cell facing an arbitrary direction.
//
//	Post Conditions:
//		All tiles that can be reached are painted in RED.
//		The robot is located at its original cell facing the original direction
//
//	Condition:
//		The robot does not step on a cell painted RED
//*/
//
//public class PaintFloor
//{
//	private static Robot r = new Robot() ;
//
//	private static final int EMPTY = 0 ;	// colors of a cell
//	private static final int RED   = 1 ;
//	private static final int BLUE  = 2 ;
//
//	private static final int FORWARD  = 0 ;	// direction of motion
//	private static final int BACKWARD = 2 ;
//
//	private static final int FRONT = 0 ;	// direction
//	private static final int RIGHT = 1 ;
//	private static final int BACK  = 2 ;
//	private static final int LEFT  = 3 ;
//
//
//
//	public static void main( String[] args )
//	{
//		paintFloor( ) ;
//	}
//
//	public static void paintFloor( )
//	{
//		// The robot marks the current cell blue
//		//r.paint( RED ) ;
//		r.paint( BLUE ) ;	// mark the currect cell
//
//		// The robot paints the region at the FRONT,
//		// starting and finishing at the original direction
//		if( r.check( FRONT ) == EMPTY)
//		{
//			r.move( FORWARD ) ;
//			paintFloor() ;
//			r.move( BACKWARD ) ;
//		}
//
//		// The robot paints the region at the RIGHT,
//		// starting and finishing at the original direction
//		if( r.check( RIGHT ) == EMPTY)
//		{
//			r.turn( RIGHT ) ;
//			paintFloor() ;
//			r.turn( LEFT ) ;
//
//		}
//
//		// The robot paints the region at the LEFT
//		// starting and finishing at the original direction
//		if( r.check( LEFT ) == EMPTY)
//		{
//			r.turn( LEFT ) ;
//			paintFloor() ;
//			r.turn( RIGHT ) ;
//		}
//
//		// Paint the region at the BACK
//		// starting and finishing at the original direction
//		if( r.check( BACK ) == EMPTY)
//		{
//			r.turn( BACK ) ;
//			paintFloor() ;
//			r.turn( BACK ) ;
//
//		}
//
//		r.paint(RED) ;	// paint teh currnt cell on the way back
//
//	}
//
//}
