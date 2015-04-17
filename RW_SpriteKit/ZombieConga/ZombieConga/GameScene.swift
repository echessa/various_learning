//
//  GameScene.swift
//  ZombieConga
//
//  Created by Joyce Echessa on 3/14/15.
//  Copyright (c) 2015 Echessa. All rights reserved.
//

import SpriteKit

class GameScene: SKScene {
    
    let zombie: SKSpriteNode = SKSpriteNode(imageNamed: "zombie1")
    var lastUpdateTime: NSTimeInterval = 0
    var dt: NSTimeInterval = 0
    let zombieMovePointsPerSec: CGFloat = 480.0
    var velocity = CGPointZero
    let playableRect: CGRect
    var lastTouchLocation: CGPoint?
    let zombieRotateRadiansPerSec:CGFloat = 4.0 * π
    let zombieAnimation: SKAction
    
    override init(size: CGSize) {
        let maxAspectRatio:CGFloat = 16.0 / 9.0
        let playableHeight = size.width / maxAspectRatio
        let playableMargin = (size.height - playableHeight) / 2.0
        playableRect = CGRect(x: 0, y: playableMargin, width: size.width, height: playableHeight)
        
        var textures: [SKTexture] = []
        for i in 1...4 {
            textures.append(SKTexture(imageNamed: "zombie\(i)"))
        }
        textures.append(textures[2])
        textures.append(textures[1])
        zombieAnimation = SKAction.repeatActionForever(SKAction.animateWithTextures(textures, timePerFrame: 0.1))
        
        super.init(size: size)
    }
    
    required init(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func debugDrawPlayableArea() {
        let shape = SKShapeNode()
        let path = CGPathCreateMutable()
        CGPathAddRect(path, nil, playableRect)
        shape.path = path
        shape.strokeColor = SKColor.redColor()
        shape.lineWidth = 4.0
        addChild(shape)
    }
    
    override func didMoveToView(view: SKView) {
        backgroundColor = SKColor.whiteColor()
        
        let background = SKSpriteNode(imageNamed: "background1")
        background.position = CGPoint(x: size.width / 2, y: size.height / 2)
        background.zPosition = -1
        addChild(background)
        
        let mySize = background.size
        
        zombie.position = CGPoint(x: 400, y: 400)
        addChild(zombie)
        
//        zombie.runAction(SKAction.repeatActionForever(zombieAnimation))
        
        runAction(SKAction.repeatActionForever(SKAction.sequence([SKAction.runBlock(spawnEnemy), SKAction.waitForDuration(2.0)])))
        
        debugDrawPlayableArea()
    }
    
    override func update(currentTime: NSTimeInterval) {
        
        if lastUpdateTime > 0 {
            dt = currentTime - lastUpdateTime
        } else {
            dt = 0
        }
        
        lastUpdateTime = currentTime
        
        if let lastTouch = lastTouchLocation {
            let diff = lastTouch - zombie.position
            if (diff.length() <= zombieMovePointsPerSec * CGFloat(dt)) {
                zombie.position = lastTouchLocation!
                velocity = CGPointZero
                stopZombieAnimation()
            } else {
                moveSprite(zombie, velocity: velocity)
                rotateSprite(zombie, direction: velocity, rotateRadiansPerSec: zombieRotateRadiansPerSec)
            }
        }
        
        boundsCheckZombie()
        
    }
    
    func moveSprite(sprite: SKSpriteNode, velocity: CGPoint) {
        let amountToMove = velocity * CGFloat(dt)
        sprite.position += amountToMove
    }
    
    func moveZombieToward(location: CGPoint) {
        startZombieAnimation()
        let offset = location - zombie.position
        let direction = offset.normalized()
        velocity = direction * zombieMovePointsPerSec
    }
    
    func sceneTouched(touchLocation:CGPoint) {
        lastTouchLocation = touchLocation
        moveZombieToward(touchLocation)
    }
    
    override func touchesBegan(touches: NSSet, withEvent event: UIEvent) {
        let touch = touches.anyObject() as UITouch
        let touchLocation = touch.locationInNode(self)
        sceneTouched(touchLocation)
    }
    
    override func touchesMoved(touches: NSSet, withEvent event: UIEvent) {
        let touch = touches.anyObject() as UITouch
        let touchLocation = touch.locationInNode(self)
        sceneTouched(touchLocation)
    }
    
    func boundsCheckZombie() {
        let bottomLeft = CGPoint(x: 0, y: CGRectGetMinY(playableRect))
        let topRight = CGPoint(x: size.width, y: CGRectGetMaxY(playableRect))
        
        if zombie.position.x <= bottomLeft.x {
            zombie.position.x = bottomLeft.x
            velocity.x = -velocity.x
        }
        if zombie.position.x >= topRight.x {
            zombie.position.x = topRight.x
            velocity.x = -velocity.x
        }
        if zombie.position.y <= bottomLeft.y {
            zombie.position.y = bottomLeft.y
            velocity.y = -velocity.y
        }
        if zombie.position.y >= topRight.y {
            zombie.position.y = topRight.y
            velocity.y = -velocity.y
        } 
    }
    
    func rotateSprite(sprite: SKSpriteNode, direction: CGPoint, rotateRadiansPerSec: CGFloat) {
        let shortest = shortestAngleBetween(sprite.zRotation, velocity.angle)
        let amountToRotate = min(rotateRadiansPerSec * CGFloat(dt), abs(shortest))
        sprite.zRotation += shortest.sign() * amountToRotate
    }
    
    func spawnEnemy() {
        let enemy = SKSpriteNode(imageNamed: "enemy")
        enemy.position = CGPoint(x: size.width + enemy.size.width / 2, y: CGFloat.random(min: CGRectGetMinY(playableRect) + enemy.size.height/2, max: CGRectGetMaxY(playableRect) - enemy.size.height/2))
        addChild(enemy)
        
        let actionMove = SKAction.moveToX(-enemy.size.width / 2, duration: 2.0)
        let actionRemove = SKAction.removeFromParent()
        enemy.runAction(SKAction.sequence([actionMove, actionRemove]))
    }
    
    func startZombieAnimation() {
        if (zombie.actionForKey("animation") == nil) {
            zombie.runAction(SKAction.repeatActionForever(zombieAnimation), withKey: "animation")
        }
    }
    
    func stopZombieAnimation() {
        zombie.removeActionForKey("animation")
    }
    
}

//class GameScene: SKScene {
//    let zombie = SKSpriteNode(imageNamed: "zombie1")
//    var lastUpdateTime: NSTimeInterval = 0
//    var dt: NSTimeInterval = 0
//    let zombieMovePointPerSec: CGFloat = 480.0
//    var velocity = CGPointZero
//    let playableRect: CGRect
//    
//    override init(size: CGSize) {
//        let maxAspectRatio: CGFloat = 16.0 / 9.0
//        let playableHeight = size.width / maxAspectRatio
//        let playableMargin = (size.height - playableHeight) / 2.0
//        playableRect = CGRect(x: 0, y: playableMargin, width: size.width, height: playableHeight)
//        super.init(size: size)
//    }
//    
//    required init(coder aDecoder: NSCoder) {
//        fatalError("init(coder:) has not been implemented")
//    }
//    
//    override func didMoveToView(view: SKView) {
//        backgroundColor = SKColor.whiteColor()
//        let background = SKSpriteNode(imageNamed: "background1")
//        background.position = CGPoint(x: size.width / 2, y: size.height / 2)
//        background.zPosition = -1
////        background.anchorPoint = CGPointZero
////        background.position = CGPointZero
////        background.zRotation = CGFloat(M_PI) / 8
//        addChild(background)
//        
//        zombie.position = CGPoint(x: 400, y: 400)
////        zombie.setScale(2.0)
//        addChild(zombie)
//        
//        let mySize = background.size
////        println("Size: \(mySize)")
//        debugDrawPlayableArea()
//    }
//    
//    override func update(currentTime: NSTimeInterval) {
//        if (lastUpdateTime > 0) {
//            dt = currentTime - lastUpdateTime
//        } else {
//            dt = 0
//        }
//        lastUpdateTime = currentTime
////        println("\(dt*1000) milliseconds since last update")
//        
////        moveSprite(zombie, velocity: CGPoint(x: zombieMovePointPerSec, y: 0))
//        moveSprite(zombie, velocity: velocity)
//        boundsCheckZombie()
//        rotateSprite(zombie, direction: velocity)
//    }
//    
//    func moveSprite(sprite: SKSpriteNode, velocity: CGPoint) {
//        let amountToMove = CGPoint(x: velocity.x * CGFloat(dt), y: velocity.y * CGFloat(dt))
////        println("Amount to move: \(amountToMove)")
//        sprite.position = CGPoint(x: sprite.position.x + amountToMove.x, y: sprite.position.y + amountToMove.y)
//    }
//    
//    func moveZombieToward(location: CGPoint) {
//        let offset = CGPoint(x: location.x - zombie.position.x, y: location.y - zombie.position.y)
//        let length = sqrt(Double(offset.x * offset.x + offset.y * offset.y))
//        let direction = CGPoint(x: offset.x / CGFloat(length), y: offset.y / CGFloat(length))
//        velocity = CGPoint(x: direction.x * zombieMovePointPerSec, y: direction.y * zombieMovePointPerSec)
//    }
//    
//    func sceneTouched(touchLocation: CGPoint) {
//        moveZombieToward(touchLocation)
//    }
//    
//    override func touchesBegan(touches: NSSet, withEvent event: UIEvent) {
//        let touch = touches.anyObject() as UITouch
//        let touchLocation = touch.locationInNode(self)
//        sceneTouched(touchLocation)
//    }
//    
//    override func touchesMoved(touches: NSSet, withEvent event: UIEvent) {
//        let touch = touches.anyObject() as UITouch
//        let touchLocation = touch.locationInNode(self)
//        sceneTouched(touchLocation)
//    }
//    
//    func boundsCheckZombie() {
//        let bottomLeft = CGPoint(x: 0, y: CGRectGetMinY(playableRect))
//        let topRight = CGPoint(x: size.width, y: CGRectGetMaxY(playableRect))
//        
//        if (zombie.position.x <= bottomLeft.x) {
//            zombie.position.x = bottomLeft.x
//            velocity.x = -velocity.x
//        }
//        
//        if (zombie.position.x >= topRight.x) {
//            zombie.position.x = topRight.x
//            velocity.x = -velocity.x
//        }
//        
//        if (zombie.position.y <= bottomLeft.y) {
//            zombie.position.y = bottomLeft.y
//            velocity.y = -velocity.y
//        }
//        
//        if (zombie.position.y >= topRight.y) {
//            zombie.position.y = topRight.y
//            velocity.y = -velocity.y
//        }
//    }
//    
//    func debugDrawPlayableArea() {
//        let shape = SKShapeNode()
//        let path = CGPathCreateMutable()
//        CGPathAddRect(path, nil, playableRect)
//        shape.path = path
//        shape.strokeColor = SKColor.redColor()
//        shape.lineWidth = 4.0
//        addChild(shape)
//    }
//    
//    func rotateSprite(sprite: SKSpriteNode, direction: CGPoint) {
//            sprite.zRotation = CGFloat(atan2(Double(direction.y), Double(direction.x)))
//    }
//}
