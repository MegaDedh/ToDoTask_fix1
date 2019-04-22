var groupIndex: Int = 0

fun main() {
    val ToDoTaskManager = ToDoTaskManager()

    //////////////////////БЛОК ЗАПОЛНЕНИЯ ДАННЫМИ ДЛЯ ТЕСТА begin///////////////////////////////////////////
    ToDoTaskManager.addTaskGroup("Разработка под Android")
    ToDoTaskManager.addTaskGroup("Автомобиль")
    ToDoTaskManager.addTaskGroup("Поход на Алтай")
    ToDoTaskManager.addTaskGroup("Зохватить весь Мир)")

    ToDoTaskManager.addTask(1, "Пойти на FocusStart", Task.Priority.HIGH)
    ToDoTaskManager.addTask(1, "Освоить Kotlin", Task.Priority.NORMAL)
    ToDoTaskManager.changeTaskStatus(1, 1)
    ToDoTaskManager.addTask(2, "Заменить масло в ДВС", Task.Priority.NORMAL)
    ToDoTaskManager.addTask(2, "Заменить масло в АККП", Task.Priority.NORMAL)
    ToDoTaskManager.addTask(2, "Починить тормоза!", Task.Priority.HIGH)
    ToDoTaskManager.addTask(2, "Заменить свечи", Task.Priority.LOW)
    ToDoTaskManager.addTask(2, "Помыть машину", Task.Priority.LOW)

    //   println(ToDoTaskManager.showTaskItemsInTaskList(2))
    //   println(ToDoTaskManager.changeTaskStatus(2,6))
    //   println(ToDoTaskManager.showTaskItemsInTaskList(2))
//////////////////////БЛОК ЗАПОЛНЕНИЯ ДАННЫМИ ДЛЯ ТЕСТА end///////////////////////////////////////////

    println(Const.GROUP_LIST)
    println(ToDoTaskManager.showTaskGroups())
    println(Const.HELP_COMMAND)


    var readString: String
    loop@ while (true) {
        readString = readLine()!!


        when {
            Const.KEY_SHOW_LIST in readString -> {
                println(Const.GROUP_LIST)
                println(ToDoTaskManager.showTaskGroups())
            }

            Const.KEY_SHOW_LIST in readString -> {
                println(Const.GROUP_LIST)
                println(ToDoTaskManager.showTaskGroups())
            }

            Const.KEY_ADD_GROUP in readString -> {
                val addName = readString.substringAfter(' ')
                println(ToDoTaskManager.addTaskGroup(addName))
            }

            Const.KEY_SHOW_GROUP in readString -> {
                try {
                    groupIndex = readString.substringAfter(' ').toInt()
                    println(ToDoTaskManager.showTasks(groupIndex))
                } catch (e: NumberFormatException) {
                    println(Const.INVALID_COMMAND)
                } catch (e: Exception) {
                    println(Const.ERROR_COMMON_EXCEPTION)
                }
            }

            Const.KEY_ADD_TASK in readString -> {
                println(Const.ENTER_PRIORITY)
                val addName = readString.substringAfter(' ')
                try {
                    val priorityInt = readLine()!!.toInt()
                    if (priorityInt !in 1..4) {
                        throw IllegalArgumentException(Const.INVALID_PRIORITY)
                    }
                    val result = ToDoTaskManager.addTask(groupIndex, addName, setPriority(priorityInt))
                    println(result)
                } catch (e: NumberFormatException) {
                    println(Const.INVALID_COMMAND)
                } catch (e: IllegalArgumentException) {
                    println(Const.INVALID_PRIORITY)
                } catch (e: Exception) {
                    println(Const.ERROR_COMMON_EXCEPTION)
                }
            }

            Const.KEY_CHANGE_STATUS in readString -> {
                try {
                    val taskIndex = readString.substringAfter(' ').toInt()
                    println(ToDoTaskManager.changeTaskStatus(groupIndex, taskIndex))
                } catch (e: NumberFormatException) {
                    println(Const.INVALID_COMMAND)
                } catch (e: Exception) {
                    println(Const.ERROR_COMMON_EXCEPTION)
                }
            }

            Const.KEY_DEL_TASK in readString -> {
                try {
                    val taskIndex = readString.substringAfter(' ').toInt()
                    println(ToDoTaskManager.delTask(groupIndex, taskIndex))
                } catch (e: NumberFormatException) {
                    println(Const.INVALID_COMMAND)
                } catch (e: Exception) {
                    println(Const.ERROR_COMMON_EXCEPTION)
                }
            }

            readString == Const.KEY_HELP -> {
                println("""
           ${Const.KEY_SHOW_LIST} ${Const.SHOW_LIST}
           ${Const.KEY_ADD_GROUP} ${Const.ADD_GROUP}
           ${Const.KEY_ADD_TASK} ${Const.ADD_TASK}
           ${Const.KEY_SHOW_GROUP} ${Const.SHOW_GROUP}
           ${Const.KEY_CHANGE_STATUS} ${Const.CHANGE_STATUS}
           ${Const.KEY_DEL_TASK} ${Const.DEL_TASK}
           ${Const.KEY_EXIT} ${Const.EXIT}""".trimIndent()
                )
            }
            readString == Const.KEY_EXIT -> break@loop

            else -> println("${Const.UNKNOWN_COMMAND} ${Const.HELP_COMMAND}")
        }
    }
}

private fun setPriority(priorityNum: Int) = when (priorityNum) {
    1 -> Task.Priority.LOW
    2 -> Task.Priority.NORMAL
    3 -> Task.Priority.HIGH
    4 -> Task.Priority.IMMEDIATE
    else -> Task.Priority.UNKNOWN
}