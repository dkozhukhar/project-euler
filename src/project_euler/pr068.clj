(ns project-euler.pr068)

(def magic-numbers (sorted-set-by > 1 2 3 4 5 6))

(def magic
  (for [x1 magic-numbers
        x2 (disj magic-numbers x1)
        x3 (disj magic-numbers x1 x2)
        x4 (disj magic-numbers x1 x2 x3)
        x5 (disj magic-numbers x1 x2 x3 x4)
        x6 (disj magic-numbers x1 x2 x3 x4 x5)
        :when (= (+ x1 x2 x3) (+ x4 x3 x5) (+ x6 x5 x2) )
        :when (> x4 x1)
        :when (> x6 x1)
        ]
    [x1 x2 x3 x4 x3 x5 x6 x5 x2]))


(def big-magic-numbers (sorted-set-by > 1 2 3 4 5 6 7 8 9 10))

(def big-magic
  (for [x1 big-magic-numbers
      x2 (disj big-magic-numbers x1 10)
      x3 (disj big-magic-numbers x1 x2 10)
      x4 (disj big-magic-numbers x1 x2 x3)
      :when (> x4 x1)
      x5 (disj big-magic-numbers x1 x2 x3 x4 10)
      x6 (disj big-magic-numbers x1 x2 x3 x4 x5)
      :when (> x6 x1)
      :when (= (+ x1 x2 x3) (+ x4 x3 x5) )
      x7 (disj big-magic-numbers x1 x2 x3 x4 x5 x6 10)
      x8 (disj big-magic-numbers x1 x2 x3 x4 x5 x6 x7)
      :when (= (+ x4 x3 x5) (+ x6 x5 x7) )
      x9 (disj big-magic-numbers x1 x2 x3 x4 x5 x6 x7 x8 10)
      :when (> x8 x1)
      :when (= (+ x6 x5 x7) (+ x8 x7 x9) )
      x10 (disj big-magic-numbers x1 x2 x3 x4 x5 x6 x7 x9 )
      :when (> x10 x1)
      :when (= (+ x8 x7 x9) (+ x10 x9 x2) )
      ]
  [x1 x2 x3, x4 x3 x5, x6 x5 x7, x8 x7 x9, x10 x9 x2]))

(def solve068
  (->>
  big-magic
  first
  (apply str)
  println
  time))