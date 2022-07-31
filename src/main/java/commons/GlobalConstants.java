package commons;

import lombok.Getter;
import java.io.File;

@Getter
public class GlobalConstants {
    static GlobalConstants globalConstants = null;
    public GlobalConstants(){

    }
    public static synchronized GlobalConstants getGlobalConstants(){

        if(globalConstants==null){
           globalConstants = new GlobalConstants();
        }
        return globalConstants;
    }
    private final String projectPath = System.getProperty("user.dir");
    private final String uploadFileFolder = projectPath + File.separator + "uploadFiles";
    private final String downloadFolderPath = projectPath + File.separator + "downloadedFiles";
    private final String loginPageUrl = "https://demo.guru99.com/v4/";
    private final long longTimeOut = 30;
    private final long shortTimeOut = 5;
}
