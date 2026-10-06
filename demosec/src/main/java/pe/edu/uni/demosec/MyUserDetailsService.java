package pe.edu.uni.demosec;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final RepositoryUsuario repoUsuario;

    public MyUserDetailsService(RepositoryUsuario userRepository) {
        this.repoUsuario = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repoUsuario.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        var authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsuario(),
                user.getPassword(),
                true,
                true, true, true,
                authorities
        );
    }
}
