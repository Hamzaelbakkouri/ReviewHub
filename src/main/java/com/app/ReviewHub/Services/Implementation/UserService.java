package com.app.ReviewHub.Services.Implementation;

import com.app.ReviewHub.Exceptions.NotFoundException;
import com.app.ReviewHub.Model.Dto.PersonRequest;
import com.app.ReviewHub.Model.Dto.User.UserResponse;
import com.app.ReviewHub.Model.Entity.Person;
import com.app.ReviewHub.Repository.UserRepository;
import com.app.ReviewHub.Services.Interface.User_S_Interface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService implements User_S_Interface {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserResponse save(PersonRequest personRequest) {
        Person person = this.userRepository.save(this.modelMapper.map(personRequest, Person.class));
        return this.modelMapper.map(person, UserResponse.class);
    }

    @Override
    public UserResponse find(UUID uuid) {
        return this.modelMapper.map(
                this.userRepository.findById(uuid)
                        .orElseThrow(() -> new NotFoundException("User not Found")),
                UserResponse.class);
    }

    @Override
    public Boolean remove(UUID uuid) {
        Optional<Person> person = this.userRepository.findById(uuid);
        if (person.isPresent()) {
            this.userRepository.deleteById(uuid);
            return true;
        }
       throw new NotFoundException("User Not found");
    }

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        Page<Person> answers = this.userRepository.findAll(pageable);
        return answers.map(answer -> modelMapper.map(answer, UserResponse.class));
    }

    @Override
    public Page<UserResponse> search(PersonRequest personRequest, Pageable pageable) {
        Page<Person> answers = this.userRepository.searchAllByFullNameLike(personRequest.getFullName() , pageable);
        return answers.map(answer -> modelMapper.map(answer, UserResponse.class));
    }
}
