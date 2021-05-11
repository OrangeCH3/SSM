package pers.ditto.service;

import org.apache.ibatis.annotations.Param;
import pers.ditto.entity.Books;

import java.util.List;

/**
 * @author OrangeCH3
 * @create 2021-05-07 21:06
 */
public interface BookService {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    //根据名称查询，返回一个Book
    Books queryBookByName(String bookName);
}
