package helpers

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies

object Twetter {
    fun getModelMapper() : ModelMapper {
        val modelMapper = ModelMapper()
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        return modelMapper
    }
}