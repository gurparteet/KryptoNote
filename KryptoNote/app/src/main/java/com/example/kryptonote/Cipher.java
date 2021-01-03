//Student : Gurparteet Singh Purbe
//ID: 217604851
//This lab is partnered with : Carlos Ordonez (217077629)

package com.example.kryptonote;

public class Cipher {

    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Cipher(String k){
        this.key = k ;
    }


    private String makePad(String note) {
        String pad = this.key;

        //few things about for  loop
        //first if no body ---> {} not required , only end with semi colon ; as below
        //alternatively = for loop can also be used as while loop if (iterations not known ) as  follows
        //for (  ;  pad.length() <note.length()  ;  ) ;  no X-statement and no Y-statement ; i.e. No

        for (; pad.length() < note.length(); pad += this.key) ;

        return pad;


    }





    public String Encrypt ( String note){
        String pad= makePad(note) ;
        String result="" ;

         for ( int i = 0 ; i< note.length() ; i++){
            String c= note.substring(i,i+1);
             int position =ALPHABET.indexOf(c);
             int shift=Integer.parseInt(pad.substring(i,i+1)) ;

             // int newPosition = position + shift
             //Since new position needs to be less than the length of the ALPHABET  and needs to work circularly : TWO ways ==>
             // one -  Using if statement -->  if (newPosition > Alphabet.lenght()) { newPosition = newPosition - Alphabet.length() }
             //second : used below using %-operator


             int newPosition= (position + shift)%ALPHABET.length() ;
             result+= ALPHABET.substring(newPosition,newPosition+1) ;


           }
         return result ;



    }

    public String Decrypt ( String note){
        String pad=makePad(note) ;
        String result="" ;

        for ( int i = 0 ; i< note.length() ; i++){
            String c= note.substring(i,i+1);
            int position =ALPHABET.indexOf(c);
            int shift=Integer.parseInt(pad.substring(i,i+1)) ;

            int newPosition = position-shift ;
            if (newPosition<0) {
                newPosition+= newPosition+ALPHABET.length() ;

            }
            result += ALPHABET.substring(newPosition,newPosition+1) ;


        }

        return result ;

    }




}


