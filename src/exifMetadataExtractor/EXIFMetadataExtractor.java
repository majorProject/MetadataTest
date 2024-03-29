/*
 * This is metadata extractor class built to get
 * different parameters of EXIF from a JPEG file.
 * External library need:
 *      -metadata-extractor-2.5.0-RC3.jar
 * http://www.drewnoakes.com/code/exif/
 */
package exifMetadataExtractor;

import java.io.File;
import java.io.IOException;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

/**
 *
 * @author susan
 * 
 */
public class EXIFMetadataExtractor {
    
    private Metadata metadata = null;
    private ExifSubIFDDirectory directory = null;
    
    //constructor without any parameter
    EXIFMetadataExtractor(){
    }
    
    //constructor with parameter
    /**
     * Constructor call with a parameter needed
     * @param jpegFile
     * @throws ImageProcessingException
     * @throws IOException 
     */
   EXIFMetadataExtractor(File jpegFile) throws ImageProcessingException, IOException{
        this.metadata = ImageMetadataReader.readMetadata(jpegFile);
        this.directory = metadata.getDirectory(ExifSubIFDDirectory.class);
    }
    
    
   /**
    * Reads filename and store in private variables
    * @param filename
    * @throws ImageProcessingException
    * @throws IOException 
    */
    public void readImageFile(String filename) throws ImageProcessingException, IOException{
        File jpegFile = new File(filename);
        this.metadata = ImageMetadataReader.readMetadata(jpegFile);
        this.directory = metadata.getDirectory(ExifSubIFDDirectory.class);
    }
    
    /**
     * This function returns the EXIF version of the JPEF file
     * @return EXIF version
     */
    public String getEXIFVersion(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_EXIF_VERSION);
    }
    
    /**
     * This function returns Image height
     * @return Image Height
     */
    public String getImageHeight(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT);
    }
    
    /**
     * This function returns Image Width
     * @return Image Width
     */
    public String getImageWidth(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH);
    }
    
    /**
     * This returns the image original date and time of creation
     * @return original creation date and time of image
     */
    public String getImageOriginalDateTime(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
    }
    
    /**
     * This returns the image original date only of creation
     * @return original creation date of image
     */
    public String getImageOriginalDate(){
        String dateTime = directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        String[] splitData = dateTime.split(" ");
        return splitData[0];
    }
    
    
    /**
     * This returns the image original time of creation
     * @return original creation time of image
     */
    public String getImageOriginalTime(){
        String dateTime = directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        String[] splitData = dateTime.split(" ");
        return splitData[1];
    }
    
    /**
     * This returns the image digitized date and time of creation
     * @return digitized creation date and time of image
     */
    public String getImageDigitizedDateTime(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED);
    }
    
    
    /**
     * This returns the image digitized date of creation
     * @return original digitized date of image
     */
    public String getImageDigitizedDate(){
        String dateTime = directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED);
        String[] splitData = dateTime.split(" ");
        return splitData[0];
    }
    
    /**
     * This returns the image digitized time of creation
     * @return original digitized time of image
     */
    public String getImageDigitizedTime(){
        String dateTime = directory.getDescription(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED);
        String[] splitData = dateTime.split(" ");
        return splitData[1];
    }
    
    //returns the image FNumber
    /**
     * This returns the FNumber of image
     * @return FNumber of image
     */
    public String getFNumber(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_FNUMBER);
    }
    
    /**
     * This returns focal lenght of the image
     * @return Focal Length of Image
     */
    public String getFocalLength(){
        return directory.getDescription(ExifSubIFDDirectory.TAG_FOCAL_LENGTH);
    }
}
