import com.github.johnnysc.practicetdd.CustomObject
import com.github.johnnysc.practicetdd.CustomObserver
import com.github.johnnysc.practicetdd.Update

interface CustomObservable<T : CustomObject, E : CustomObserver<T>> : Update<T> {

    fun addObserver(observer: E)

    fun removeObserver(observer: E)

    class Base<T : CustomObject, E : CustomObserver<T>>(
    ) : CustomObservable<T, E> {

        private val observerList: MutableList<E> = mutableListOf()

        override fun addObserver(observer: E) {
            observerList.add(observer)
        }

        override fun removeObserver(observer: E) {
            observerList.remove(observer)
        }

        override fun update(argument: T) {
            observerList.forEach {
                if (it.canHandle(argument)) it.update(argument)
            }
        }
    }
}