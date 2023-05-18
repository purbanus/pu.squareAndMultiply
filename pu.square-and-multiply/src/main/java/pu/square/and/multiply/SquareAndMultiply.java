package pu.square.and.multiply;
import java.math.BigDecimal;

public class SquareAndMultiply
{

public static void main( String [] args )
{
	new SquareAndMultiply().runBasic();
}

public void runBasic()
{
	System.out.println( squareAndMultiply( 3, 9 ) );
	System.out.println( squareAndMultiply( 3, 39 ) );
	BigDecimal THREE = new BigDecimal( "3" );
	System.out.println( squareAndMultiply( THREE, 9 ) );
	System.out.println( squareAndMultiply( THREE, 39 ) );
	System.out.println( squareAndMultiply( THREE, 45 ) );
	BigDecimal TWENTY_THREE = new BigDecimal( "23" );
	System.out.println( squareAndMultiply( TWENTY_THREE, 323 ) );
// 68879666181043143022221223749875106258418352669552397923285639384909579474863832210525191167482712599259542942490288538439373457176343114735320541364346363083931872953343624165078124822805999992191203182928080997468803080270139901839953676223183109669848622877923857791247325989697927489773677032165957818521340481436932231520711034415948555665327322157388630123599825235463379994009316002197842286854391947242996499702686020594922407986567

}
long squareAndMultiply( long base, int power )
{
    // x^0 = 1
    if ( power == 0) return 1;

    // x^1 = x
    if ( power == 1 ) return base;

    // if power is odd
    if ( power % 2 == 1 )
    {
      // Make the power an even number by moving
      // one multiplication out of the power and
      // in front of the equation, then call the
      // the function recursively, reducing x^n
      // to (x^2)^n/2, since succesive powers are
      // multiplied in a mathematical equation pipo
      return base * squareAndMultiply( base * base, ( power-1 ) / 2 );
    }

    // else if power is even, do same as
    // for odd but without the need to make
    // it even anymore
    return squareAndMultiply( base*base , power / 2 );
}
BigDecimal squareAndMultiply( BigDecimal base, int power )
{
    // x^0 = 1
    if ( power == 0) return new BigDecimal( "1" );

    // x^1 = x
    if ( power == 1 ) return base;

    // if power is odd
    if ( power % 2 == 1 )
    {
      // Make the power an even number by moving
      // one multiplication out of the power and
      // in front of the equation, then call the
      // the function recursively, reducing x^n
      // to (x^2)^n/2, since succesive powers are
      // multiplied in a mathematical equation
      return base.multiply( squareAndMultiply( base.multiply( base ), ( power-1 ) / 2 ) );
    }

    // else if power is even, do same as
    // for odd but without the need to make
    // it even anymore
    return squareAndMultiply( base.multiply( base ) , power / 2 );
}

}
