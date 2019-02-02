package am.springboot.chat.Controllers;

import am.springboot.chat.DTO.SearchUserDto;
import am.springboot.chat.Dao.UsersDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    UsersDao usersDao;

    public HomeController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping(value="/", params = "search")
    public ResponseEntity<List<SearchUserDto>> search(@RequestParam(name = "search") String name){
        List<SearchUserDto> searchUserDtos = usersDao.loadUserByname(name);
        return searchUserDtos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(searchUserDtos);

    }


}
