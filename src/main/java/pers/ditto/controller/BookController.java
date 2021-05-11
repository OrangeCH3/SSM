package pers.ditto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.ditto.entity.Books;
import pers.ditto.service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OrangeCH3
 * @create 2021-05-07 22:05
 */
@Controller
@RequestMapping("/book")
public class BookController {

    //controller调service
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();

        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper()
    {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books)
    {
        System.out.println("addBook->"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; //重定向到allBook请求
    }

    //跳转到修改书籍的页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id, Model model)
    {
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks", books);
        return "updateBook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books)
    {
        System.out.println("updateBook->"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍的请求
    @RequestMapping("/deleteBook")
    public String deleteBook(int id)
    {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍的请求
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model)
    {
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if (books == null)
        {
            list = bookService.queryAllBook();
            model.addAttribute("error","没有查询到相关书籍");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
