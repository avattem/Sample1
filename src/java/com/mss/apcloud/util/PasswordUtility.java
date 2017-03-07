/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.apcloud.util;

/**
 *
 * @author miracle
 */
public class PasswordUtility {
      
    /** Creates a new instance of EncriptDecriptPwd */
    public PasswordUtility() {
    }
    public static void main(String rags[]){
      System.out.println(decryptPwd("@170@206@228@132@104@100@102@112"));
        
    }
  
    /** Creates a new instance of FormulaEncrypt */
    public static String encryptPwd(String src) {
        //Converting String to array
        
        char  asciiarr[] = src.toCharArray();
        
        //Finding lnegth and converting into int
        
        int encryasciiarr[]= new int[src.length()];
        
        String encrypt="";
        
        for(int i=0;i<asciiarr.length;i++) {
            // System.out.println("The origianl value are"+ (int)asciiarr[i]);
            int asciichar = (int) asciiarr[i]+2;
            int accharmul2 = asciichar*2;
            encryasciiarr[i] = accharmul2;
            
        }
        
        for(int j=0;j<encryasciiarr.length;j++) {
            
            //System.out.println("The ascii char are"+encryasciiarr[j]);
            encrypt = encrypt+"@"+encryasciiarr[j];
        }
        
        // System.out.println("The enc is"+encrypt);
        
        return encrypt;
    }//end of the encrypt method
    
   
    //this is Dycrypt Method
    public static  String decryptPwd(String enc) {
        
        String asarr[] = enc.split("@");
        //variable declaration
        
        int inval=0;
        String instr=".";
        String instr1="";
        String orval="";
        for(int lk=0;lk<asarr.length;lk++) {
            
            //System.out.println("Values are"+asarr[lk]);
            if(asarr[lk].equalsIgnoreCase(""))
                
            {
                
                instr = asarr[lk];
                //System.out.println("The value with null"+instr);
                
            } else {
                instr1 = asarr[lk];
                inval = Integer.parseInt(instr1);
                //System.out.println("Int values are"+inval);
                int divval = inval/2;
                int minusval = divval-2;
                
                orval = orval+(char) minusval;
                
                
            }
           //  System.out.println("orignal Values are"+orval.trim());
            
        }
        
        
        return orval;
        
    }//end of the dycript method
    
}
