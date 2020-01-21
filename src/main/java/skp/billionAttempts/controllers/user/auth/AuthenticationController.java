package skp.billionAttempts.controllers.user.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import skp.billionAttempts.dto.AuthenticationRequestDto;
import skp.billionAttempts.dto.GenderDto;
import skp.billionAttempts.dto.RoleDto;
import skp.billionAttempts.dto.uni_hierarchy.FacultyDto;
import skp.billionAttempts.model.user.base_user.Role;
import skp.billionAttempts.model.user.base_user.User;
import skp.billionAttempts.model.user.Gender;
import skp.billionAttempts.repository.uni_hierarchy.DirectionRepository;
import skp.billionAttempts.repository.uni_hierarchy.FacultyRepository;
import skp.billionAttempts.repository.uni_hierarchy.StudyGroupRepository;
import skp.billionAttempts.security.jwt.JwtTokenProvider;
import skp.billionAttempts.service.UserService;

import java.util.*;

@RestController
@RequestMapping(value = "/api/auth/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private UserService userService;

    private FacultyRepository facultyRepository;

    private DirectionRepository directionRepository;

    private StudyGroupRepository studyGroupRepository;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtTokenProvider jwtTokenProvider,
                                    UserService userService,
                                    FacultyRepository facultyRepository,
                                    DirectionRepository directionRepository,
                                    StudyGroupRepository studyGroupRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.facultyRepository = facultyRepository;
        this.directionRepository = directionRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));

            User user = userService.findByUsername(requestDto.getUsername());

            if (Objects.isNull(user)) {
                throw new UsernameNotFoundException("User with username: " + requestDto.getUsername() + " not found");
            }

            String token = jwtTokenProvider.createToken(requestDto.getUsername(), new ArrayList<>(user.getRoles()));

            Map<Object, Object> response = new HashMap<>();
            response.put("username", requestDto.getUsername());
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @GetMapping("reg/roles")
    public List<RoleDto> getRoles() {
        return RoleDto.fromRoles(Role.getRolesExceptUser());
    }

    @GetMapping("reg/genders")
    public List<GenderDto> getGender() {
        return GenderDto.fromGenderList(Arrays.asList(Gender.values()));
    }

    @GetMapping("reg/faculties")
    public List<FacultyDto> getFaculties() {
        return FacultyDto.fromFaculties(facultyRepository.findAll());
    }

}
