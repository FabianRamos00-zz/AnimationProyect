package Properties;

import java.io.IOException;
import java.util.Properties;

public class Language extends Properties {
	 
    public Language(String language){
        switch(language){
            case "Español":
                    getProperties("Spanish.properties");
                    break;
            case "Ingles":
                    getProperties("English.properties");
                    break;
            default:
                    getProperties("Spanish.properties");
        }
    }
 
    private void getProperties(String text) {
        try {
            this.load(getClass().getResourceAsStream(text));
        } catch (IOException ex) {
        }
   }
}
