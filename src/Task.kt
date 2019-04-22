internal data class Task constructor(
    val taskTitle: String,
    val taskPriority: Priority
) {
    var title: String = taskTitle
    var priority: Priority = taskPriority
    var status: Boolean = false

    enum class Priority (val value: String){
        LOW("Низкий"),
        NORMAL("Нормальный"),
        HIGH("Высокий"),
        IMMEDIATE("Неотложный"),
        UNKNOWN("Без приоритета"),
    }
}