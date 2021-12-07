
public class Combinaisons{
	
	//premiere section
	
	public int un = 0;
    public int deux = 0;
    public int trois = 0;
    public int quatre = 0;
    public int cinq = 0;
    public int six = 0;
    public boolean aBonus = false;
    
    //deuxieme section
    
	public int brelan;
    public int carre;
    public boolean aBrelan = false;
    public boolean aCarre = false;
    public boolean aFull = false;
    public boolean aPetiteSuite = false;
    public boolean aGrandeSuite = false;
    public boolean aYam = false;
    
    //S1
    
    public int countUp(int valeur, De[] des){
    	//renvoie le nombre n de dés qui ont la valeur valeur.
    	int nbValeur=0;
    	for(int i=0; i<5; i++) {
    		if(des[i].getValeur()== valeur)
    			nbValeur++;
    	}
    	return nbValeur;		
    }
    
    
    public void setUn(De[] des) {
    	un= 1* countUp(1,des);
    }
    
    public void setDeux(De[]des) {
    	deux=2*countUp(2,des);
    }
    
    public void setTrois(De[] des) {
       trois=3*countUp(3,des);
    }
    
    public void setQuatre(De[] des) {
    	quatre=4*countUp(4,des);
    }
    
    public void setCinq(De[] des) {
    	cinq=5*countUp(5,des);
    }
    
    public void setSix(De[] des) {
    	six=6*countUp(6,des);
    }
    
    // S2

    public void setBrelan(De[]des) {
        //3 faces pareilles
        if ((countUp(1,des)==3) || (countUp(2,des)==3) || (countUp(3,des)==3) 
        		|| (countUp(4,des)==3) || (countUp(5,des)==3) || (countUp(6,des)==3)){
        	int somme=0;
            for(int i=0; i<des.length;i++) {
                somme = somme + i;
            }
            brelan = somme;
            aBrelan = true;
        } else {
            aBrelan = false;
        }
    }
    
    public void setCarre(De[]des) {
        //4 faces pareilles
        if ((countUp(1,des)==4) || (countUp(2,des)==4) || (countUp(3,des)==4) 
        		|| (countUp(4,des)==4) || (countUp(5,des)==4) || (countUp(6,des)==4)){
        	int somme=0;
            for(int i=0; i<des.length;i++) {
                somme = somme + i;
            }
            carre = somme;
            aCarre = true;
        } else {
            aCarre = false;
        }
    }
    
   
    
    public void setFull(De[]des) {
        // un brelan + une paire
        if (((countUp(1,des)==3) || (countUp(2,des)==3) || (countUp(3,des)==3) 
        		|| (countUp(4,des)==3) || (countUp(5,des)==3) || (countUp(6,des)==3)) 
        		&& ((countUp(1,des)==2) || (countUp(2,des)==2) || (countUp(3,des)==2) 
        		|| (countUp(4,des)==2) || (countUp(5,des)==2) || (countUp(6,des)==2))){
        	int somme=0;
            for(int i=0; i<des.length;i++) {
                somme = somme + i;
            } 
            aFull = true;
        } else {
            aFull = false;
        }
    }
    
    public void setPsuite(De[]des) {
    	// 1234, 2345, 3456
    	int cpt1=0, cpt2=0, cpt3=0, cpt4=0, cpt5=0, cpt6=0;
    	for(int i=0; i<des.length;i++) {
    		if (des[i].getValeur()==1)
    			cpt1++;
    		if (des[i].getValeur()==2)
    			cpt2++;
    		if (des[i].getValeur()==3)
    			cpt3++;
    		if (des[i].getValeur()==4)
    			cpt4++;
    		if (des[i].getValeur()==5)
    			cpt5++;
    		else
    			cpt6++;	
    	}
        if ((cpt1==1) && (cpt2==1) && (cpt3==1) && (cpt4==1)) {
            aPetiteSuite = true;
        } else if ((cpt2==1) && (cpt3==1) && (cpt4==1) && (cpt5==1)) {
        	aPetiteSuite = true;
        } else if ((cpt3==1) && (cpt4==1) && (cpt5==1) && (cpt6==1)) {
        	aPetiteSuite = true;
        } else {
        	aPetiteSuite = false;
        }
    }
    
    public void setGsuite(De[]des) {
    	int cpt1=0, cpt2=0, cpt3=0, cpt4=0, cpt5=0, cpt6=0;
    	for(int i=0; i<des.length;i++) {
    		if (des[i].getValeur()==1)
    			cpt1++;
    		if (des[i].getValeur()==2)
    			cpt2++;
    		if (des[i].getValeur()==3)
    			cpt3++;
    		if (des[i].getValeur()==4)
    			cpt4++;
    		if (des[i].getValeur()==5)
    			cpt5++;
    		else
    			cpt6++;	
    	}
        if ((cpt1==1) && (cpt2==1) && (cpt3==1) && (cpt4==1) && (cpt5==1)) {
            aGrandeSuite = true;
        } else if ((cpt2==1) && (cpt3==1) && (cpt4==1) && (cpt5==1) && (cpt6==1)) {
        	aGrandeSuite = true;
        } else {
        	aGrandeSuite = false;
        }
    }
    
    public void setYam(De[]des) {
    	if ((countUp(1,des)==5) || (countUp(2,des)==5) || (countUp(3,des)==5) 
        		|| (countUp(4,des)==5) || (countUp(5,des)==5) || (countUp(6,des)==5)){
            aYam = true;
        }
        else{
            aYam = false;
        }
    }
    
}
