UPDATE youmiteru_backend.season
SET reduced_description = v.reduced_description
FROM (
  VALUES
    ('Повседневная жизнь маленького социопата наполнена комичными ситуациями, которые можно увидеть, если смотреть аниме "Boku no Kokoro no Yabai Yatsu".'),
    ('Повседневная жизнь маленького социопата наполнена комичными ситуациями, которые можно увидеть, если смотреть аниме "Boku no Kokoro no Yabai Yatsu".'),
    ('В классе Нисикаты учится девочка по имени Такаги. Весёлая, симпатичная — глаз не оторвать.'),
    ('В классе Нисикаты учится девочка по имени Такаги. Весёлая, симпатичная — глаз не оторвать.'),
    ('Взмахни волшебной палочкой, произнеси заклинание — так делаются все дела в мире магии, от работы по дому до сражений за судьбу мира.'),
    ('Взмахни волшебной палочкой, произнеси заклинание — так делаются все дела в мире магии, от работы по дому до сражений за судьбу мира.'),
    ('Уже полгода прошло с того момента, как 17-летнюю Маомао похитили и заставили трудиться в императорском дворце обычной служанкой.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Четырнадцатилетний Идзуку Мидория рано осознал, что люди не рождаются равными.'),
    ('Человек — существо социальное, ему требуется взаимодействие с окружающими не только посредством диалога, но и тактильного контакта.'),
    ('Жить в феодальной Японии непросто... особенно если вас завоевали инопланетяне.'),
    ('Жить в феодальной Японии непросто... особенно если вас завоевали инопланетяне.'),
    ('Жить в феодальной Японии непросто... особенно если вас завоевали инопланетяне.'),
    ('Жить в феодальной Японии непросто... особенно если вас завоевали инопланетяне.'),
    ('Жить в феодальной Японии непросто... особенно если вас завоевали инопланетяне.')
) AS v (reduced_description)
CROSS JOIN youmiteru_backend.season s;