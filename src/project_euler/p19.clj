(ns project-euler.p19
  )



;Counting Sundays
;Problem 19
;You are given the following information, but you may prefer to do some research for yourself.

;1 Jan 1900 was a Monday.
;Thirty days has September,
;April, June and November.
;All the rest have thirty-one,
;Saving February alone,
;Which has twenty-eight, rain or shine.
;And on leap years, twenty-nine.
;A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
;How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?



(def y-m-d
  "Just cann't stop myself of making a big list ...
  ([1901 :jan 1] [1901 :jan 2] [1901 :jan 3] [1901 :jan 4] [1901 :jan 5]  and so on"
 (apply concat
 (apply concat
  (for [year (range 1900 2001)]
    (for [month [:jan :feb :mar :apr :may :jun :jul :aug :sep :oct :nov :dec]]
      (let [monlen
            (cond
             (= month :sep) 30
             (= month :apr) 30
             (= month :jun) 30
             (= month :nov) 30
             (= month :feb)
                 (cond
                  (= 0 (rem year 400)) 29
                  (= 0 (rem year 100)) 28
                  (= 0 (rem year 4)) 29
                  :else 28)
             :else 31)]
                  (for [daynumer (range 1 (inc monlen))]
                    `[~year ~month ~daynumer]))

    )))))


(println
(let [days [:mon :tu :we :th :fr :sa :su]
      md (map conj y-m-d (cycle days) )
      check (fn [[y m d w]] (and (= d 1) (= w :su) (not= y 1900)))]

  (count (filter check md))
  ;(filter check md)
  ;md
  ))

; => 171