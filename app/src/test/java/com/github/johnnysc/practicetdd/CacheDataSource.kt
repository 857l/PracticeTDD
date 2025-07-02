package com.github.johnnysc.practicetdd

interface CacheDataSource {

    fun add(item: com.github.johnnysc.practicetdd.SimpleData)
    fun data(): List<com.github.johnnysc.practicetdd.SimpleData>

    class Timed(
        private val now: Now,
        private val lifeTimeMillis: Int
    ) : CacheDataSource {

        private var cache = mutableListOf<CachedItem>()

        override fun add(item: com.github.johnnysc.practicetdd.SimpleData) {
            cache.add(CachedItem(item, now.now()))
        }

        override fun data(): List<com.github.johnnysc.practicetdd.SimpleData> {
            val currentTime = now.now()
            val alive = cache.filter { cachedItem ->
                currentTime - cachedItem.timeStamp <= lifeTimeMillis
            }
            cache.clear()
            cache = alive.toMutableList()
            return cache.map { it.data }
        }

    }

}