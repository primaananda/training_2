/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogikaProposisi;

/**
 *
 * @author primaananda
 */
public class Parser {
    private int x = 0;
    private int token_lexic = 0;
    private int[] token = new int[1000];
    private char[] karakter;
    private String outp;
    
    public static int cekPQRS(char[] n){
        int x = 0;
        int token_lexic = 0;
        try{
            if((n[x] == 'P') || (n[x] == 'p')
                    || (n[x] == 'Q') || (n[x] == 'q')
                    || (n[x] == 'R') || (n[x] == 'r')
                    || (n[x] == 'S') || (n[x] == 's')){
                token_lexic = 1;
            }
            if(n.length>1){token_lexic = 0;}
        }catch(Exception e){}
        return token_lexic;
    }
    public int cekAnd(char[] n){
        try {
           if((n[x] == 'A') || (n[x] == 'a')){
                x++;
                if((n[x] == 'N') || (n[x] == 'n')){
                    x++;
                    if((n[x] == 'D') || (n[x] == 'd')){
                        token_lexic = 2;
                    }
                }  
            }
           if(n.length>3){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekOr(char[] n){
        try {
            if((n[x] == 'O') || (n[x] == 'o')){
                token_lexic++;
                if((n[x] == 'R') || (n[x] == 'r')){
                    token_lexic=3;
                }  
            }
            if(n.length>2){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekXor(char[] n){
        try {
            if((n[x] == 'X') || (n[x] == 'x')){
                x++;
                if((n[x] == 'O') || (n[x] == 'o')){
                    x++;
                    if ((n[x] == 'R') || (n[x] == 'r')) {
                        token_lexic=4;
                    }
                }  
            }
            if(n.length>3){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekIf(char[] n){
        try {
            if((n[x] == 'I') || (n[x] == 'i')){
                token_lexic++;
                if((n[x] == 'F') || (n[x] == 'f')){
                        token_lexic = 5;
                }  
            }
            if(n.length>2){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekThen(char[] n){
        try {
            if((n[x] == 'T') || (n[x] == 't')){
                x++;
                if((n[x] == 'H') || (n[x] == 'h')){
                    x++;
                    if ((n[x] == 'E') || (n[x] == 'e')) {
                        x++;
                        if ((n[x] == 'N') || (n[x] == 'n')) {
                            token_lexic = 6;
                        }
                    }
                }  
            }
            if(n.length>4){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekIff(char[] n){
        try {
            if((n[x] == 'I') || (n[x] == 'i')){
                x++;
                if((n[x] == 'F') || (n[x] == 'i')){
                    token_lexic++;
                    if ((n[x] == 'F') || (n[x] == 'i')) {
                        token_lexic = 7;
                    }
                }  
            }
            if(n.length>3){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekKurungBuka(char[] n){
        try {
            if (n[x] == '(') {
                token_lexic = 8;
            }
            if(n.length>1){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    public int cekKurungTutup(char[] n){
        try {
            if (n[x] == ')') {
                token_lexic = 9;
            }
            if(n.length>1){token_lexic = 0;}
        } catch (Exception e) {
        }
        return token_lexic;
    }
    
    public void cekProposisi(String hasil){
        String[] split = hasil.split(" ");
        for (int i = 0; i < split.length; i++) {
            token[i] = 0;
            karakter = split[i].toCharArray();
            if(token[i] == 0){
                token[i] = cekPQRS(karakter);
            }if (token[i] == 0){
                token[i] = cekAnd(karakter);
            }if (token[i] == 0){
                token[i] = cekIf(karakter);
            }if (token[i] == 0){
                token[i] = cekIff(karakter);
            }if (token[i] == 0){
                token[i] = cekKurungBuka(karakter);
            }if (token[i] == 0){
                token[i] = cekKurungTutup(karakter);
            }if (token[i] == 0){
                token[i] = cekOr(karakter);
            }if (token[i] == 0){
                token[i] = cekThen(karakter);
            }if (token[i] == 0){
                token[i] = cekXor(karakter);
            }
            outp = outp + " " + token[i];
        }
    }
    
    public void cekValidasi(){
        
    }
    
}
