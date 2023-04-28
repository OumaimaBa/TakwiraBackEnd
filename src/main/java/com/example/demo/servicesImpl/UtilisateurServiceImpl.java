package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;
import com.example.demo.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	private UtilisateurRepository userRepo;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Utilisateur getUtilisateurById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addUtilisateur(Utilisateur user) {
	    Optional<Utilisateur> verif = userRepo.findById(user.getUsername());
	    if (verif.isPresent()) {
	        return false;
	    } else {
	    	String encodedPassword = passwordEncoder.encode(user.getMdp());
	        user.setMdp(encodedPassword);
	        userRepo.save(user);
	        return true;
	    }
	}


	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login( String username, String password) {
	    Optional<Utilisateur> user = userRepo.findFirstByUsername(username);

	    if (user.isEmpty() || (user.isPresent() && (!BCrypt.checkpw(password, user.get().getMdp())))) {
	    	return "tatatatataaaaaa";
	    }else {
		    return "bravooooo";
	    }
	}

	@Override
	public String getNameUser(String username) {
		Optional<Utilisateur> user = userRepo.findById(username);
			return user.get().getNom() + ' ' + user.get().getPrenom();
	}
	

}
