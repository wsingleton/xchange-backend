package com.xchange.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xchange.models.Company;
import com.xchange.models.User;
import com.xchange.repositories.CompanyRepository;
import com.xchange.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CompanyRepository companyRepo;

	@Override
    public User addUser(User u) {
        ArrayList<User> users = new ArrayList<User>();
        users = (ArrayList<User>) userRepo.findAll();
        for(User user : users) {
            if(user.getUsername().equals(u.getUsername())) {
                u.setUserName(null);
                return u;
            }
            if(user.getEmail().equals(u.getEmail())) {
                u.setEmail(null);
                return u;
            }
        }
        return userRepo.save(u);
    }

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Long id) {
		return userRepo.getOne(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
    public User updateUserById(Long userId, User u) {
        ArrayList<User> users = new ArrayList<User>();
        users = (ArrayList<User>) userRepo.findAll();
        for(User user : users) {
            if(!user.getUserId().equals(u.getUserId())) {
                if(user.getUsername().equals(u.getUsername())) {
                    u.setUserName(null);
                    return u;
                }
                if(user.getEmail().equals(u.getEmail())) {
                    u.setEmail(null);
                    return u;
                }
            }
        }
        User user = userRepo.findOne(userId);
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setEmail(u.getEmail());
        user.setUserName(u.getUsername());
        user.setPassword(u.getPassword());
        return userRepo.save(user);        
    }

	public User loginUser(User u) {
		return userRepo.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

	@Override
	public Set<User> addUserSubscription(Long user1_id, Long user2_id) {
		User followingUser = userRepo.findOne(user1_id);
		User followedUser = userRepo.findOne(user2_id);
		followingUser.getUserSubscriptions().add(followedUser);
		return followingUser.getUserSubscriptions();
	}

	@Override
	public Set<Company> addUserFavorite(Long user_id, Long company_id) {
		User user = userRepo.findOne(user_id);
		Company company = companyRepo.findOne(company_id);
		user.getUserFavorites().add(company);
		return user.getUserFavorites();
	}

	@Override
	public Set<User> findAllUserSubscriptions(Long user_id) {
		User user = userRepo.findOne(user_id);
		return user.getUserSubscriptions();
	}

	@Override
	public Set<Company> findAllUserFavorites(Long user_id) {
		User user = userRepo.findOne(user_id);
		return user.getUserFavorites();
	}

	@Override
	public void removeUserSubscription(Long user1_id, Long user2_id) {
		User followingUser = userRepo.findOne(user1_id);
		User followedUser = userRepo.findOne(user2_id);
		followingUser.getUserSubscriptions().remove(followedUser);
	}

	@Override
	public void removeUserFavorite(Long user_id, Long company_id) {
		User user = userRepo.findOne(user_id);
		Company company = companyRepo.findOne(company_id);
		user.getUserFavorites().remove(company);
	}
}
