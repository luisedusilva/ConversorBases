
package Conversor;

public class Numero {
    private byte base; // A base do numero
   private String valor; // O Valor do numero
   

   public byte getBase ()
   {
      return base;
   }
   
  
   public String getValor ()
   {
      return valor;
   }
   
  
   public void setBase ( byte r )
   {
      if ( ( r >= 2 ) && ( r <= 16 ) )
         base = r;
      else
         base = 10;
   }
   
  
   public byte setValor ( String v, byte r )
   {
      byte resultado = verValor( v, r );
      
      if ( resultado == 0 )
         valor = v;
      else
         valor = "0";
      
      return resultado;
   }
   

   public String toBase ( byte r )
   {
      String aux = new String( valor );
      
      if ( base == r )
         return String.valueOf( aux );
      else if ( base == 10 )
         return decPara( String.valueOf( aux ), r );
      else if ( r == 10 )
         return paraDec( String.valueOf( aux ), base );
      else
         return decPara( paraDec( String.valueOf( aux ), base ), r );
   }
   
 
   private byte verValor ( String v, byte r )
   {
      String val = new String ( v );
      
      // Verificando se algo foi digitado
      if ( val.length() > 0 ) {
         
	 // Verificando cada digito do numero de entrada
	 for ( int i = 0; i < val.length(); i++ ) {
            
	    // Podem haver apenas letras ou digitos no numero
	    if ( Character.isDigit( val.charAt( i ) ) ||
	       Character.isLetter( val.charAt( i ) ) ) {
	       
		  // Verificando se o digito condiz com a base especificada
		  if ( Character.digit( val.charAt( i ), 16 ) >= r )
	             return ( byte ) 3;
	    }
	    else
	       return ( byte ) 2; // Caracter invalido
         } 
         
         return ( byte ) 0; // Valor valido
      }
      else
         return ( byte ) 1; // Valor nulo
   }
   
   /**
    * Converte um número de decimal para binário, octal ou hexadecimal.
    */
   private String decPara ( String num, byte base )
   {
      long n = Long.parseLong( num );
      String retorno = "";
      
      while ( n >= base ) {
         if ( n % base < 9 )
	    retorno = ( n % base ) + retorno;
	 else
	    retorno = Character.forDigit( ( byte ) ( n % base ), base ) + retorno;
         n /= base;
      }
   
      if ( n < 9 )
         retorno = n + retorno;
      else
         retorno = Character.forDigit( ( byte ) ( n % base ), base ) + retorno;
      
      return retorno;
   }

   
   /**
    * Converte um número de binário, octal ou hexadecimal para decimal.
    */
   private String paraDec ( String num, byte base )
   {
      int i, exp;
      long n = 0;
      String aux = new String( num );
      
      for ( i = aux.length() - 1, exp = 0; i >= 0; i--, exp++ )
	    n += Math.pow( base, exp ) * Character.digit( aux.charAt( i ), base );
   
      return Long.toString( n );
   }
} 

