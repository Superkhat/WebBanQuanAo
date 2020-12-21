package com.dev.Sales.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.PhanQuyenEntity;
import com.dev.Sales.Repositories.NguoiDungRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired private NguoiDungRepository nguoidungRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String us = "null";
		String pass = "null";
		String role = "USER";
		int count =0;
		for(NguoiDungEntity nguoidung : nguoidungRepository.findAll()) {
			if(username.equals(nguoidung.getUserName())) {
				List<PhanQuyenEntity> Lphanquyen = new ArrayList<PhanQuyenEntity>();
				
				for(PhanQuyenEntity p : nguoidung.getLphanQuyen()) {
					Lphanquyen.add(p);
					System.out.println("tetstt" +p.getQuyen_phanQuyen().getTenQuyen());
				}
				for(PhanQuyenEntity phanquyen: Lphanquyen)
					if(phanquyen.getQuyen_phanQuyen().getTenQuyen().equals("ADMIN")) {
						us=nguoidung.getUserName();
						pass = nguoidung.getPassWord();
						role="ADMIN";
						count++;
						break;
					}
						
			}
		}
		if(count==0) {
			throw new UsernameNotFoundException("Sai userName hoặc PassWord");
		}
		// TODO truy cập vào database để lấy thông tin username
		return new User(us, pass, Arrays.asList(new SimpleGrantedAuthority(role)));
	}

}
