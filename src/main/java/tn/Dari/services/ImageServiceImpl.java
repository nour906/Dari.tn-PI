package tn.Dari.services;

import org.springframework.stereotype.Service;

import tn.Dari.entities.Image;
import tn.Dari.repository.ImageRepository;
import tn.Dari.utility.ImageUtility;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
    ImageRepository imageRepository;
/*
    @Override
    public Image uplaodImage(MultipartFile file) throws IOException {
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .picByte(ImageUtility.compressImage(file.getBytes())).build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository.findImageById(id);

        return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .picByte(ImageUtility.decompressImage(dbImage.get().getPicByte())).build() ;
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException{
        final Optional<Image> dbImage = imageRepository.findImageById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getPicByte()));
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

  */

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteImage(Long id) {
		// TODO Auto-generated method stub
		
	}
}