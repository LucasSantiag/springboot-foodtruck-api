package com.foodtruck.api.exceptions

import lombok.Getter
import lombok.Setter

@Setter
@Getter
class ExceptionsAttributes(
        private val message: String?,
        private val details: String,
        private val uri: String,
        private val time: Long?
)
