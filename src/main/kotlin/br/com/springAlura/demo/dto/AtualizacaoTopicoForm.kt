package br.com.springAlura.demo.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AtualizacaoTopicoForm (
    @field: NotNull
    val id: Long,
    @field: NotEmpty
    val titulo:String,
    @field: NotNull
    val mensagem: String

)
