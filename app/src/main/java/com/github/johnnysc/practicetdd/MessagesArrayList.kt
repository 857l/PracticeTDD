package com.github.johnnysc.practicetdd

class MessagesArrayList : ArrayList<MessageUI>() {

    override fun add(element: MessageUI): Boolean {
        val id = this.size.toString()
        return super.add(element.copyWithId(id))
    }
}