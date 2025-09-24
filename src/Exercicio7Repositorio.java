import java.util.*;

interface Identificavel<ID> {
    ID getId();
}

interface IRepository<T extends Identificavel<ID>, ID> {
    void salvar(T entidade);
    Optional<T> buscarPorId(ID id);
    List<T> listarTodos();
    void remover(ID id) throws Exception;
}

class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {
    private Map<ID, T> banco = new HashMap<>();

    public void salvar(T entidade) {
        banco.put(entidade.getId(), entidade);
    }

    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(banco.get(id));
    }

    public List<T> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(banco.values()));
    }

    public void remover(ID id) throws Exception {
        if (!banco.containsKey(id)) {
            throw new Exception("Entidade não encontrada para remoção");
        }
        banco.remove(id);
    }
}

class ProdutoRepo implements Identificavel<Integer> {
    private int id;
    private String nome;

    public ProdutoRepo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
}

public class Exercicio7Repositorio {
    public static void main(String[] args) {
        IRepository<ProdutoRepo, Integer> repo = new InMemoryRepository<>();
        ProdutoRepo p = new ProdutoRepo(1, "Caneta");
        repo.salvar(p);

        System.out.println("Produto salvo: " + repo.buscarPorId(1).get().getNome());
        System.out.println("Total produtos: " + repo.listarTodos().size());
    }
}
