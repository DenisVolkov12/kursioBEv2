package ru.kursio.application.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import ru.kursio.application.model.exception.KursioException;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public final class FileUtils {

    private static Logger log = LoggerFactory.getLogger(FileUtils.class.getName());

    public static File convertMultiPartToFile(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            log.error("Error generated in class: convertMultiPartToFile");
            throw new KursioException("Error thrown in the method -> convertMultiPartToFile(MultipartFile file), with the following details: ", e);
        } catch (IOException e) {
            log.error("An Error generated in class: convertMultiPartToFile");
            throw new KursioException("Error thrown in the method -> convertMultiPartToFile(MultipartFile file), with the following details: ", e);
        }
        return convFile;
    }

    public static String generateFileName(MultipartFile multiPart) {
        return multiPart.getOriginalFilename().replace(" ", "_");
    }

    public InputStream convertMultipartToInputStream(MultipartFile source) {
        try {
            return source.getInputStream();
        }
        catch (IOException e) {
            log.error("Error generated in class: MultipartFileToInputStreamConverter");
            Exception ilegalArgument = new IllegalArgumentException("Cannot convert MultipartFile to InputStream", e);
            throw new KursioException("Error thrown in the method -> convert(MultipartFile source), with the following details: ", ilegalArgument);
        }
    }

    public static Blob convertMultipartToBlob(MultipartFile file) {
        Blob blob;
        try {
            byte[] bytes = file.getBytes();
            blob = new SerialBlob(bytes);
        } catch (SQLException e) {
            log.error("Error generated in class: convertMultipartToBlob");
            throw new KursioException("Error thrown in the method -> convertMultipartToBlob(MultipartFile file), with the following details: ", e);
        }
        catch (IOException ioe) {
            log.error("Error generated in class: convertMultipartToBlob");
            throw new KursioException("An Error thrown in the method -> convertMultipartToBlob(MultipartFile file), with the following details: ", ioe);
        }
        return blob;
    }

    public static File convertBlobToFile(Blob blob, String fileName) {
        File f = null;
        try {
            InputStream in = blob.getBinaryStream();
            OutputStream out = new FileOutputStream(f = new File(fileName));
            byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
            int len = 0;

            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        }catch(IOException ioe){ throw new KursioException("IO Exception ERROR", ioe);}
        catch(SQLException sqle){ throw new KursioException("SQL Exception ERROR", sqle);}

        return f;
    }
}
