
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class UsuarioMB implements Serializable {

    private List<Usuario> listaUsuarios;
    private boolean logado;
    private Usuario usuario;

    public UsuarioMB() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("admin", "admin"));
        listaUsuarios.add(new Usuario("user1", "123"));
        listaUsuarios.add(new Usuario("user2", "123"));
        listaUsuarios.add(new Usuario("user3", "123"));

        usuario = new Usuario();
        logado = false;
    }

    public boolean isLogado() {
        return logado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String verificaLogin() {
        if (listaUsuarios.contains(usuario)) {
            logado = true;
            return ("home?faces-redirect=true");
        } else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login inválido!", "Usuário ou senha estão errados!");
            contexto.addMessage("idMensagem", mensagem);
            return ("index?faces-redirect=true");
        }

    }

    public String realizaLogout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return ("index?faces-redirect=true");
    }

}
