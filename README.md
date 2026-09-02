# Sistema de Cadastro de Ninjas

Uma API REST desenvolvida com Spring Boot para gerenciar Ninjas e suas Missões, implementando arquitetura em camadas, tratamento global de erros e controle de migrações.

## Visão Geral

- Cadastro de ninjas com nome, idade, email e rank
- Gerenciamento de missões
- Relacionamento one-to-many: uma missão pode ter vários ninjas
- Validações de negócio centralizadas

## Tecnologias

- Java, Spring Boot, Spring Data JPA
- H2 Database (em memória)
- Flyway (controle de migrações)
- Maven, Docker, Git

## Modelo de Banco de Dados

### Tabela NINJA
| Campo     | Tipo      |
|-----------|-----------|
| id        | Long      |
| nome      | String    |
| idade     | Integer   |
| email     | String    |
| rank      | String    |
| missao_id | Long (FK) |

### Tabela MISSAO
| Campo     | Tipo   |
|-----------|--------|
| id        | Long   |
| titulo    | String |
| descricao | String |

## Arquitetura em Camadas

```
Controller (REST Endpoints)
    |
    v
Service (Regras de Negócio)
    |
    v
Repository (Acesso a Dados)
    |
    v
Database (H2)
```

### Controller
- Recebe requisições HTTP
- Delega lógica ao serviço
- Retorna respostas

```java
@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {
    
    @Autowired
    private NinjaService service;
    
    @GetMapping
    public List<NinjaDTO> listar() {
        return service.listarTodos();
    }
}
```

### Service
- Implementa regras de negócio
- Valida dados de domínio
- Orquestra operações
- Gerencia transações

```java
@Service
public class NinjaService {
    
    @Autowired
    private NinjaRepository repository;
    
    public NinjaDTO criar(NinjaCriacaoDTO dto) {
        // Validações e lógica
        return repository.save(ninja);
    }
}
```

### Repository
- Abstrai acesso ao banco
- Operações CRUD
- Queries customizadas

```java
@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
    List<Ninja> findByMissaoId(Long missaoId);
}
```

## Handler Global de Erros

Tratamento centralizado de exceções via `@RestControllerAdvice`:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
        EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(
            new ErrorResponse(404, ex.getMessage()));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
        MethodArgumentNotValidException ex) {
        return ResponseEntity.status(400).body(
            new ErrorResponse(400, "Dados inválidos"));
    }
}
```

**Benefícios:**
- Respostas padronizadas
- Reduz duplicação de try-catch
- Logs automáticos
- Tratamento único de erros

## Migrações com Flyway

Gerencia evolução do banco de dados de forma versionada.

### Estrutura
```
src/main/resources/db/migration/
├── V1__create_tables.sql
├── V2__add_constraints.sql
└── V3__insert_initial_data.sql
```

### Convenção
- `V` + número + `__` + descrição + `.sql`
- Exemplo: `V1__create_tables.sql`
- Versões sequenciais (V1, V2, V3...)

### Funcionamento
1. Flyway verifica `flyway_schema_history` na inicialização
2. Executa apenas migrações não processadas
3. Registra cada execução
4. Falha se migração anterior foi modificada

### Exemplo
```sql
CREATE TABLE ninja (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    idade INT,
    email VARCHAR(255),
    rank VARCHAR(100),
    missao_id BIGINT,
    FOREIGN KEY (missao_id) REFERENCES missao(id)
);
```

**Boas práticas:**
- Nunca modifique migrações executadas
- Crie novas versões para alterações
- Teste em desenvolvimento antes

## Execução

1. Clone o repositório:
```bash
git clone https://github.com/mateuspetris/CadastroNinjas.git
```

2. Build e execução:
```bash
cd CadastroNinjas
mvn clean install
mvn spring-boot:run
```

3. Acesse:
```
http://localhost:8080
```

4. Console H2:
```
http://localhost:8080/h2-console
```

## Endpoints Principais

**Ninjas:**
- `GET /api/ninjas` - Listar todos
- `GET /api/ninjas/{id}` - Obter por ID
- `POST /api/ninjas` - Criar
- `PUT /api/ninjas/{id}` - Atualizar
- `DELETE /api/ninjas/{id}` - Deletar

**Missões:**
- `GET /api/missoes` - Listar todos
- `POST /api/missoes` - Criar
- `PUT /api/missoes/{id}` - Atualizar

Se este projeto foi útil para você, considere deixar uma ⭐ no repositório!