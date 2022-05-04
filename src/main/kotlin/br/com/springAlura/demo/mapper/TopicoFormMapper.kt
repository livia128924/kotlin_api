package br.com.springAlura.demo.mapper

import br.com.springAlura.demo.dto.NovoTopicoForm
import br.com.springAlura.demo.model.Topico
import br.com.springAlura.demo.service.CursoService
import br.com.springAlura.demo.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}