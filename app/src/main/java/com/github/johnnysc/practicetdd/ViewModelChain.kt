package com.github.johnnysc.practicetdd

class ViewModelChain(
    private val featureChain: FeatureChain.CheckAndHandle
) : FeatureChain.Handle {

    private var nextFeatureChain: FeatureChain.Handle = FeatureChain.Empty

    fun nextFeatureChain(nextFeatureChain: FeatureChain.Handle) {
        this.nextFeatureChain = nextFeatureChain
    }

    override suspend fun handle(message: String): MessageUI =
        if (featureChain.canHandle(message)) {
            featureChain.handle(message)
        } else {
            nextFeatureChain.handle(message)
        }
}