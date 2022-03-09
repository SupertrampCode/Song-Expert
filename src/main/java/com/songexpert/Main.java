package com.songexpert;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
      ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

//
////        Genre genre = new Genre();
////        genre.setName("Vad");
//        GenreImpDAO genreImpDAO = new GenreImpDAO();
////        genre=genreImpDAO.save(genre);
////        Band band = new Band();
////        band.setName("Imagine Dragon's");
//        BandRepository bandImplDAO = new BandImplDAO();
//        band=bandImplDAO.save(band);
//        Song song = new Song();
//        song.setName("CHERVONA RUTA");
//        song.setBand(band);
//        song.setGenre(genre);
//
//        SongImplDAO songImplDAO= new SongImplDAO();
////
////        dao.save(song);
//        songImplDAO.getAllByBand(bandImplDAO.findById(1L)).forEach(System.out::println);
//        songImplDAO.getAllByGenre(genreImpDAO.findById(1L)).forEach(System.out::println);
    }
}
