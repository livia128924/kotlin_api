package br.com.springAlura.demo.service

import br.com.springAlura.demo.dto.AtualizacaoTopicoForm
import br.com.springAlura.demo.dto.NovoTopicoForm
import br.com.springAlura.demo.dto.TopicoView
import br.com.springAlura.demo.mapper.TopicoFormMapper
import br.com.springAlura.demo.mapper.TopicoViewMapper
import br.com.springAlura.demo.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
    ) {


    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return  topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) : TopicoView{
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topicos = topicos.minus(topico).plus(Topico(
                id = form.id,
                titulo = form.titulo,
                mensagem = form.mensagem,

                autor = topico.autor,
                curso = topico.curso,
                respostas = topico.respostas,
                status = topico.status,
                dataCriacao = topico.dataCriacao
        ))




    }

    fun deletar(id: Long) {

        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicos = topicos.minus(topico)
    }

}