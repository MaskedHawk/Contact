package contacts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Phonebook {
    //attributes
    private final ArrayList<Person> mybook = new ArrayList<>();
    //methods
    public void addperson(String name, String address, String number){
       Person tmp = new Person (name, address, number);
	mybook.add(tmp);
    }
    
    public int size(){
        return mybook.size();
    }
    
    public String getName(int i){
        return mybook.get(i).getname();
    }
    
    public void SetName(int i, String name){
        mybook.get(i).setname(name);
    }
    
    public String getAddress(int i){
        return mybook.get(i).getaddress();
    }
    
     public void SetAddress(int i, String address){
        mybook.get(i).setaddress(address);
    }
     
    public String getNumber(int i){
        return mybook.get(i).getnumber();
    }
    
    public void SetNumber(int i, String number){
        mybook.get(i).setnumber(number);
    }
    
    public void remove(int index){
        mybook.remove(index);
    }
    
    public int find(String tmpName, String tmpNumber)
    {
         for(int i = 0; i < mybook.size() ;i++)
         {
             if(tmpNumber.equals(mybook.get(i).getnumber())
                     && tmpName.equals(mybook.get(i).getname()))
                return i;
         }
         return -1;
    }
   
    public Phonebook readcsv(String filename){
        if(!filename.toLowerCase().contains(".csv"))
            filename = filename + ".csv";
        Phonebook tmpbook = new Phonebook();
        String csvFile = filename;
	BufferedReader file = null;
        String line;
	String csvSplit = ";";
		
	try {
		file = new BufferedReader(new FileReader(csvFile));
                
		while ((line = file.readLine()) != null){
                    String[] data = line.split(csvSplit);
                    tmpbook.addperson(data[0], data[1], data[2]);
		}		
            } 
        catch (FileNotFoundException e){
            return null;
        } 
        catch (IOException e){
            return null;
        } 
        finally {
            if (file != null) {
                try {
                    file.close();
                } 
                catch (IOException e){
                    return null;
                }
            }
        }
        return tmpbook;
    }  
    
    public void savecsvPerson(String filename){
	if(!filename.toLowerCase().contains(".csv"))
            filename = filename + ".csv";
        try{
            File file = new File(filename);
            //test if file doesnt exists
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for(int i = 0; i < mybook.size() ; i++)
                {
                    bw.write(this.getName(i) + ";" + this.getAddress(i) + ";" + this.getNumber(i));
                    bw.newLine();
                }
            }
	}catch (IOException e){
            e.printStackTrace();
	}
    }
}
