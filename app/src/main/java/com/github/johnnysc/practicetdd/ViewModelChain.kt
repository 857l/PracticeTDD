package com.github.johnnysc.practicetdd

abstract class ViewModelChain(
    private val feature: FeatureChain.CheckAndHandle
) : FeatureChain.CheckAndHandle {

    private var featureChain: FeatureChain.Handle = FeatureChain.Empty

    fun nextFeatureChain(featureChain: FeatureChain.Handle) {
        this.featureChain = featureChain
    }

    override fun canHandle(message: String): Boolean = feature.canHandle(message)

    override suspend fun handle(message: String): MessageUI =
        if (feature.canHandle(message)) {
            feature.handle(message)
        } else featureChain.handle(message)
}