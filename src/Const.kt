class Const {
    companion object {
        const val KEY_SHOW_LIST = "showList"
        const val KEY_SHOW_GROUP = "showGroup"
        const val KEY_ADD_GROUP = "addGroup"
        const val KEY_ADD_TASK = "addTask"
        const val KEY_CHANGE_STATUS = "changeStatus"
        const val KEY_EXIT = "exit"
        const val KEY_HELP = "?"

        const val GROUP_LIST = "Список групп задач:"
        const val HELP_COMMAND = "Для получения списка команд наберите \"?\""
        const val UNKNOWN_COMMAND = "Вы пытаетесь выполнить неведомую команду."
        const val INVALID_COMMAND = "Невозможно выполнить команду. Возможно команда введена некорректно"
        const val ERROR_COMMON_EXCEPTION = "Ошибка выполнения. Что-то пошло не так"
        const val SHOW_LIST = "- показать список групп"
        const val ADD_GROUP = "[название группы] - добавить группу задач"
        const val ADD_TASK = "[название задачи] - добавить задачу в последнюю просмотренную группу"
        const val SHOW_GROUP = "[номер группы задач] - просмотр содержимого группы задач"
        const val CHANGE_STATUS = "[номер задачи] - изменить статус выполнения задачи из последней просмотренной группы"
        const val EXIT = "- выход из программы"
        const val ENTER_PRIORITY = "Введите приоритет задачи (от 1 до 4)"
        const val INVALID_PRIORITY = "Неверно введён приоритет. Значение должно быть в диапазоне [1-4]"
        const val GROUP_NOT_EXIST = "Группа задач с таким номером отсутствует."
        const val TASK_NOT_EXIST = "Задача с таким номером отсутствует"
        const val TASK_OR_GROUP_NOT_EXIST = "Задача либо группа задач с таким номером отсутствует."
        const val USE_SHOW_GROUP = "Для проверки используйте showGroup"
        const val EMPTY_GROUP = "В списке ещё не создано ни одной задачи"
        const val CHANGE_STATUS_OK = "Статус задачи успешно изменён"
        const val CHANGE_STATUS_ERROR = "Ошибка изменения статуса."

    }
}