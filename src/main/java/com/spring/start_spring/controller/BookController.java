package com.spring.start_spring.controller;

import com.spring.start_spring.dto.AvtorDto;
import com.spring.start_spring.dto.BookDto;
import com.spring.start_spring.dto.ResponsDto;
import com.spring.start_spring.entity.Avtor;
import com.spring.start_spring.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BookController {
    private List<Book> list = new ArrayList<>();
    private List<BookDto> bookDtoList = new ArrayList<>();

    private List<Avtor> list2 = new ArrayList<>();
    private List<AvtorDto> list3 = new ArrayList<>();

    @GetMapping("/getBooc")
    public BookDto getByid(@RequestParam Integer id) {
        list2.add(new Avtor("Abdumalik", "Sobirov", 2003, 1));
        list2.add(new Avtor("Yusuf", "Mahmudov", 2002, 2));
        list2.add(new Avtor("Sardor", "Shorahimov", 2004, 3));
        list.add(new Book(1, "Salom dunyo", 45000, 1));
        list.add(new Book(2, "Ufq", 70000, 2));
        list.add(new Book(3, "Alvido vatan", 25000, 3));


        for (Book book : list) {
            if (book.getId() == id) {
                for (Avtor avtor : list2)
                    if (avtor.getId() == book.getAvterid()) {
                        return new BookDto(book.getId(), book.getName(), book.getPrice(), avtor.getName());
                    }
            }
        }
        return null;
    }


    @GetMapping("/getBooksortavtorid")
    public List<Avtor> getByid1() {
        list2.add(new Avtor("Sardor", "Shorahimov", 2004, 3));
        list2.add(new Avtor("Yusuf", "Mahmudov", 2002, 2));
        list2.add(new Avtor("Abdumalik", "Sobirov", 2003, 1));
        Collections.sort(list2, (a, b) -> a.getId() - b.getId());
        return list2;
    }

    @GetMapping("/getBooksortbookid")
    public List<Book> getBybookid() {
        list.add(new Book(1, "Salom dunyo", 45000, 3));
        list.add(new Book(2, "Ufq", 70000, 2));
        list.add(new Book(3, "Alvido vatan", 25000, 1));
        Collections.sort(list, (a, b) -> a.getId() - b.getId());
        return list;
    }

    @GetMapping("/getBoocavtordtoid")
    public AvtorDto getByid3(@RequestParam Integer id) {
        list3.add(new AvtorDto("Abdumalik", "Sobirov", 2003, 1));
        list3.add(new AvtorDto("Yusuf", "Mahmudov", 2002, 2));
        list3.add(new AvtorDto("Sardor", "Shorahimov", 2004, 3));
        for (AvtorDto avtordto : list3) {
            if (avtordto.getId() == id) {
                return new AvtorDto(avtordto.getName(), avtordto.getLastname(), avtordto.getId(), avtordto.getYear());
            }
        }
        return null;

    }

    @GetMapping("/getBoocavtordtoname")
    public AvtorDto getByname(@RequestParam String name) {
        list3.add(new AvtorDto("Abdumalik", "Sobirov", 2003, 1));
        list3.add(new AvtorDto("Yusuf", "Mahmudov", 2002, 2));
        list3.add(new AvtorDto("Sardor", "Shorahimov", 2004, 3));
        for (AvtorDto avtordto : list3) {
            if (avtordto.getName().equals(name)) {
                return new AvtorDto(avtordto.getName(), avtordto.getLastname(), avtordto.getId(), avtordto.getYear());
            }
        }
        return null;
    }

    @GetMapping("/getBoocavtordtoyear")
    public AvtorDto getByyear(@RequestParam Integer year) {
        list3.add(new AvtorDto("Abdumalik", "Sobirov", 2003, 1));
        list3.add(new AvtorDto("Yusuf", "Mahmudov", 2002, 2));
        list3.add(new AvtorDto("Sardor", "Shorahimov", 2004, 3));
        for (AvtorDto avtordto : list3) {
            if (avtordto.getYear() == year) {
                return new AvtorDto(avtordto.getName(), avtordto.getLastname(), avtordto.getId(), avtordto.getYear());
            }
        }
        return null;

    }

    @GetMapping("/getTubson")
    public List<Integer> tub(@RequestParam Integer num){
        List<Integer> list5 = new ArrayList<>();
        for(int i = 2;i<=num;i++) {
            int count = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) count++;
            }
            if (count == 0) list5.add(i);
        }
        return list5;
    }

    @PatchMapping("/updatebook")
    public ResponsDto updatebook(@RequestBody BookDto bookDto){
        bookDtoList.add(new BookDto(1, "Salom dunyo", 45000, "Sardor"));
        bookDtoList.add(new BookDto(2, "Ufq", 70000, "Yusuf"));
        bookDtoList.add(new BookDto(3, "Alvido vatan", 25000, "Abdumalik"));
        for(BookDto b : bookDtoList){
            if(b.getId().equals(bookDto.getId())){
                if(bookDto.getName() != null) b.setName(bookDto.getName());
                if(bookDto.getAvtorname() != null) b.setAvtorname(bookDto.getAvtorname());
                if(bookDto.getPrice() != null) b.setPrice(bookDto.getPrice());
                return ResponsDto.builder()
                        .code(0)
                        .succes(true)
                        .message("update")
                        .build();
            }
        }
        return ResponsDto.builder()
                .code(1)
                .succes(false)
                .message("not update")
                .build();
    }
}
