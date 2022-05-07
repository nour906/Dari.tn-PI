package tn.Dari.controller;

import java.io.ByteArrayOutputStream;
import tn.Dari.utility.ImageUtility;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import java.io.ByteArrayOutputStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import tn.Dari.entities.Image;
import tn.Dari.repository.ImageRepository;
import tn.Dari.services.ImageService;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
@RequestMapping(path = "/image")
public class ImageController {

	
	 @Autowired
	    ImageService imageService ;
	 @Autowired
	 ImageRepository imageRepository;
	 
	 @PostMapping("/upload")
		public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			Image img = new Image(null, file.getOriginalFilename(), file.getContentType(),
					5, compressBytes(file.getBytes()));
			imageRepository.save(img);
			return (BodyBuilder) ResponseEntity.status(HttpStatus.OK);
		}
	 
		@GetMapping(path = { "/get/{imageName}" })
		public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
			final Optional<Image> retrievedImage = imageRepository.findByName(imageName);
			Image imge = new Image(null, retrievedImage.get().getName(), retrievedImage.get().getType(),1, decompressBytes(retrievedImage.get()
					.getPicByte()));
			return imge;
			/*return Image.builder()
	                .idImage(retrievedImage.get().getIdImage())
	                .name(retrievedImage.get().getName())
	                .type(retrievedImage.get().getType())
	                .picByte(ImageUtility.decompressImage(retrievedImage.get().getPicByte())).build(); */
		}
		
		// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	 
///////////////////////////::
/*
	    @RequestMapping(value = "/uploads" , method = RequestMethod.POST)
	    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	        return imageService.uplaodImage(file);
	    }

	    @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	        return imageService.getImageDetails(id) ;
	    }

	    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
	        return imageService.getImage(id) ;
	    }


	    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	    public void deleteImage(@PathVariable("id") Long id){
	        imageService.deleteImage(id);
	    }
	    */
}
