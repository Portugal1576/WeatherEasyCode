package com.portugal1576.weathereasycode.data.model

import java.io.Serializable

data class WeatherCloud(
    val current: Current,
    val location: Location
) : Serializable