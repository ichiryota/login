package com.room.reserve.login;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.room.reserve.loginmapper.Loginmapper;
@Controller
public class logincontroller {
	@Autowired
	Loginmapper loginmapper;
	//ブラウザを立ち上げ、localhostの検索をかけた際に行う処理
	@RequestMapping(value="/")
	public String login(Model model) {
		Login login=new Login();
		login.name=null;
		login.pass=null;
		login.uname=null;
		model.addAttribute("name",login);
		return "login";
	}
	//ログイン画面でログインボタンを押した際に行う処理
	@PostMapping(value="/check")
	public String check(Login login,Model model) {
		List<Login> list=loginmapper.selectAll(login);//DB内に格納されているすべての情報を取得
		model.addAttribute("name",list);//コントローラからビューに値を渡す
		if(list.size()>0)
			return "date";//date.htmlを開く
		else {
			model.addAttribute("name",login);//コントローラからビューに値を渡す
			model.addAttribute("message","ユーザ名とパスワードが一致しません");//エラーメッセージをビューに渡す
			return "login";
		}
	}
}
